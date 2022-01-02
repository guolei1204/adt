import java.util.Date;
import scala.collection.immutable.List

sealed trait CarInfo

object CarInfo {

  sealed trait Empty extends CarInfo

  sealed trait Name extends CarInfo

  sealed trait Manufacturer extends CarInfo

  sealed trait Model extends CarInfo

  sealed trait SerialNumber extends CarInfo

  sealed trait License extends CarInfo

  sealed trait LicenseDate extends CarInfo

  sealed trait Extras extends CarInfo

  sealed trait CurrentKm extends CarInfo

  type MandatoryInfo = Empty with Name with Manufacturer with Model
    with SerialNumber with License with LicenseDate
    with Extras with CurrentKm
}

case class MyCarPOJOBuilder[I <: CarInfo](
                                           name: String = "", manufacturer: String = "", model: String = "",
                                           serialNbr: String = "", license: String = "", licenseDate: Date = new Date(),
                                           currentKm: Int = 0,
                                           carStandName: String = "N/A", sellerName: String = "N/A") {

  def withName(name: String): MyCarPOJOBuilder[I with CarInfo.Name] =
    this.copy(name = name)

  def withManufacturer(manufacturer: String): MyCarPOJOBuilder[I with CarInfo.Manufacturer] =
    this.copy(manufacturer = manufacturer)

  def withModel(model: String): MyCarPOJOBuilder[I with CarInfo.Model] =
    this.copy(model = model)

  def withSerialNumber(serialNbr: String): MyCarPOJOBuilder[I with CarInfo.SerialNumber] =
    this.copy(serialNbr = serialNbr)

  def withLicense(license: String): MyCarPOJOBuilder[I with CarInfo.License] =
    this.copy(license = license)

  def withLicenseDate(licenseDate: Date): MyCarPOJOBuilder[I with CarInfo.LicenseDate] =
    this.copy(licenseDate = licenseDate)

  def withCurrentKm(currentKm: Int): MyCarPOJOBuilder[I with CarInfo.CurrentKm] =
    this.copy(currentKm = currentKm)

  // Optional parameters
  def withCarStandName(carStandName: String): MyCarPOJOBuilder[I] =
    this.copy(carStandName = carStandName)

  def withSellerName(sellerName: String): MyCarPOJOBuilder[I] = this.copy(sellerName = sellerName)

  def build(implicit ev: I =:= CarInfo.MandatoryInfo): MyCarPOJO =
    MyCarPOJO(name, manufacturer, model, serialNbr,
      license, licenseDate,  currentKm,
      carStandName, sellerName)
}

case class MyCarPOJO(name: String, manufacturer: String, model: String,
                     serialNbr: String, license: String, licenseDate: Date,
                     currentKm: Int,
                     carStandName: String, sellerName: String)