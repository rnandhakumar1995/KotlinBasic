class Student constructor(private val firstName: String, private val middleName:String, private val lastName: String) {
    //private primary constructor
    var fullName: String

    init {
        println("Executing while calling the primary constructor")
        fullName = "$firstName $middleName"
        println(fullName)
    }

    init {
        println("This will be print next to the above one as init gets executed as per the same order it defined")
        fullName = "$fullName $lastName"
        println(fullName)
    }
}