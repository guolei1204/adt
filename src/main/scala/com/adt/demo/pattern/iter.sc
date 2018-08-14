case class Student(name:String,age:Int)

class StudentIterator(students: Array[Student]) extends Iterator[Student] {
  private var currentPos = 0
  override def hasNext = currentPos < students.length

  override def next() = {
    val r = students(currentPos)
    currentPos+=1
    r
  }
}


val students = new StudentIterator(Array.apply(Student("aa",1), Student("bb", 2),Student("cc",3)))

students.foreach(println)
