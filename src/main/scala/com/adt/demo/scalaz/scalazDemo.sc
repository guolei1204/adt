

import scalaz.{Lens,LensFamily}

case class Country(name: String, code: String)

case class City(name: String, country: Country)

case class Address(code: Int, street: String, city: City)

case class Company(name: String, address: Address)

case class Person(name: String, company: Company, address: Address)

val userCompany = Lens.lensu[Person,Company]((u,c) => u.copy(company = c),_.company)

val userAddress = Lens.lensu[Person,Address]((u,ad) => u.copy(address = ad),_.address)

val companyAddress = Lens.lensu[Company, Address](
  (c, address) => c.copy(address = address),
  _.address
)

val addressCity = Lens.lensu[Address, City](
  (a, city) => a.copy(city = city),
  _.city
)

val cityCountry = Lens.lensu[City, Country](
  (c, country) => c.copy(country = country),
  _.country
)

val countryCode = Lens.lensu[Country, String](
  (c, code) => c.copy(code = code),
  _.code
)

val userCompanyCountryCode = userCompany >=> companyAddress >=> addressCity >=> cityCountry >=> countryCode

val userCompanyCountryCodeCompose = countryCode <=< cityCountry <=< addressCity <=< companyAddress <=< userCompany

val uk = Country("United Kingdom", "uk")
val london = City("London", uk)
val buckinghamPalace = Address(1, "Buckingham Palace Road", london)
val castleBuilders = Company("Castle Builders", buckinghamPalace)

val switzerland = Country("Switzerland", "CH")
val geneva = City("geneva", switzerland)
val genevaAddress = Address(1, "Geneva Lake", geneva)

val ivan = Person("Ivan", castleBuilders, genevaAddress)
System.out.println(ivan)

System.out.println("Capitalize UK code...")

val ivanFixed = userCompanyCountryCode.mod(_.toUpperCase, ivan)
System.out.println(ivanFixed)


