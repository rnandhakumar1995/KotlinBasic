class Student constructor(firstName: String, middleName: String = "", lastName: String) {
    //private primary constructor
    var fullName: String
    var college = "Velalar College of Engineering and Technology"

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

    constructor(firstName: String, middleName: String, lastName: String, college: String) :
            this(firstName, middleName, lastName) {
        println("Secondary constructor")
        this.college = college
    }
}