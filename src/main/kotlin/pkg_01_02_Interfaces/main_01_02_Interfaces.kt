package pkg_01_02_Interfaces

// interface keyword - interface name
interface StringProvider {
    // Cannot provide a DEFAULT value for an interface property.
    val placeholder: String
    // Now to extend the utility of our interfaces, we typically want to add methods to our interface which must then be implemented by any class implementing the interface.
    // We may add a method to an interface by defining a function signature within our interface body.
    // So now any type that extends this string provider interface must either be marked abstract or implement this get string method signature.
    fun getString(id: Int): String
}

//  Interfaces may actually extend other interfaces as well.
// This ability to have interfaces which themselves implement other interfaces can be really helpful
// - when modeling data via composition.
interface ResourceProvider: StringProvider {
    // Kotlin allows us to define a DEFAULT IMPLEMENTATION for an interface method.
    fun getDimension(id:Int): String = "Default Implementation: $id"
}

class DefaultResourceProvider() : ResourceProvider {
    override val placeholder: String = "<placeholder>"
    // DEFAULT IMPLEMENTATION DONE IN INTERFACE
//    override fun getDimension(id: Int): Long {
//        return id.toLong()
//    }

    override fun getString(id: Int): String {
        return "Id: $id"
    }
}

class main_01_02_Interfaces {
    fun main() {
        // Interfaces allow us to define reusable type contracts to be implemented by other classes, objects, and even interfaces.
        // divine interface properties and default method implementations
        println("main_01_02_Interfaces")

        // (ResourceProvider) less specific type of interface - more generic type, as that is usually a helpful coding practice.
        val interfaceInstance: Any = DefaultResourceProvider()

        // Smart Casting
        if (interfaceInstance is ResourceProvider) {
            println("The variable was ResourceProvider")
            println(interfaceInstance.placeholder)
            println(interfaceInstance.getString(5))
            println(interfaceInstance.getDimension(15))
        } else {
            println("The variable wasn't ResourceProvider")
        }
    }
}