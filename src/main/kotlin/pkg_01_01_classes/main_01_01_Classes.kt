package pkg_01_01_classes

class main_01_01_Classes {

    fun main() {
        println("main_01_01_Classes")
        // Classes are used to model data types behavior and real-world objects in object-oriented programming. -cornerstone
        // To create a class in Kotlin, we right-click on the source main Kotlin directory, select New, Kotlin class/file, select Class, and name it.
        // To instantiate a new instance of the person class, we'll create a variable called "Person."
        // So here we have a new instance of the person class that we created in our file
        val person: Person = Person(1, "Adil", "Yousuf", "Adi") // followed by the open and close parentheses for the constructor.
        // Student is a subtype of person
        val student: Person = Student(1, "Adil", "Yousuf", "Adi")

        // Property access syntax
        person.age
        person.firstName
//        person.lastName
        // invoke the function
//        person.userName()
        // it is public and present in that base class, so it's accessible from the child class student.
//        student.userName()
        student.printName()
    }
}

// Basic Class Definition
class basicClassDefinition
