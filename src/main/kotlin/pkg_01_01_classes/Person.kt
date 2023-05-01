package pkg_01_01_classes

// We can provide constructor parameters to a class to initialize a property with a passed value.
// By default, these properties and parameter have all been public. - private visibility modifier
// Modify our person class to make it open for extension.
// Kotlin are closed for extension by default. This is to help enforce the concept of immutability.
// So to open up the person class for extension we add the open keyword to it before the class declaration.
open class Person ( // constructor parameter - in parentheses
    age: Int,               // parameter
    val firstName: String,  // class properties
    protected val lastName: String,   // class properties
    private val nickName: String    // private class properties
) { // curly braces

    // Init blocks are sections of code that run when an instance of a class is created.
    // Init blocks and properties are processed in the order in which they're defined within a class body.
    // If we wanted to validate the age parameter, we can add an init block before the declaration of the age property,
    init {
        // and within the init, use the check function to ensure that a parameter value is valid,
        // and if not, it throws an exception with the message we provide.
        check(age > 0) { // lambda
            "A person's age can't be negative"
        }
    }

    // A class may include variables known as class properties that are scoped to a specific instance of that class.
    // We define a class property within the class body using val or var and provide an initial value for it.
    val age: Int = age //Property

    // A method is just a function scoped to a particular class or interface.
    // Methods help us encapsulate class specific behavior in a reusable manner.
    // Single expression function - String Template
    fun userName() = println("$firstName $lastName aka $nickName")

    open fun printName() = println("$firstName $lastName aka $nickName")
}

// Classes can be extended and modified to reuse and change behavior.
// Let's create a student class that extends person.
// Once the person class has been marked as open, now we're ready to create a student
// The name of the person class, followed by parentheses representing the constructor of that person class. Now person requires constructor parameters.
class Student(age: Int, firstName: String, lastName: String, nickName: String) : Person(age, firstName, lastName, nickName) {
    // method signature - override modifier - signifies
    // This demonstrates the idea of polymorphic behavior where we have created custom behavior for the same method name.
    // And so if we had a student subtype, we could have one set of behavior.
    // We might have an instructor type that extends person. It could have another behavior for a print name.
    override fun printName() {
//        super.printName()
        println("My name is $firstName $lastName")
    }
}

// Abstract classes are like class templates.
// They define state and behavior that may be reused by classes that are going to extend the base abstract class.
// If a property is marked as abstract, the initialization is left to the class that extends the base abstract class.
abstract class AbstractClass { // class keyword - class declaration - class body - extend the base AbstractClass - abstract modifier - class level
    // By marking the property abstract in this case, we would leave the initialization to whatever class later extended the person class.
    abstract val Age: Int // property level
}