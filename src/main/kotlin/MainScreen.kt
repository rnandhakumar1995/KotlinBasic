import java.util.*

class MainScreen {
    fun showOptions() {
        val scanner by lazy { Scanner(System.`in`) }
        do {
            println(
                """Select an option 
            |1.Scope functions
            |0. Exit
            |
        """.trimMargin()
            )
            var option = scanner.nextInt()
            when (option) {
                1, 3, 4 -> with(ScopeFunctions()) {
                    println("Applied values to index ${applyUsage()}")
                    println("Run command to format date to string ${runUsage()}")
                    println("Let the function return even numbers ${letUsage()}")
                    println("Return 5 integer number. ALSO print them while creating ${alsoUsage().toMutableList()}")
                    println("With list to sequences ${withUsage(listOf(1, 2, 3)).toMutableList()}")
                }
                2 -> with(HigherOrderFunction()) {
                    functionWithCallback{
                        println("Choosen option is $option")
                    }
                }
            }
        } while (option in 1..3)
    }
}

data class Element(
    val id: String,
    val title: String
)

fun main(vararg args: String) {
    val mainScreen = MainScreen()
    mainScreen.showOptions()
//    println(Codility().solution(9))
//    println(Codility().solution(intArrayOf(1, 2, 3, 4), 4).toMutableSet())
//    println(Codility().solution(intArrayOf(9, 3, 9, 3, 9, 7, 9)))
//    val first = 3
//    val second = 15
//    println("AND of $first and $second is ${first and second}")
//    println(Codility().solution(10, 85, 30))
//    println(Codility().solution(intArrayOf(3, -2, 1, 0, 8, 7, 1), 3, true))
//    println(Codility().solution(intArrayOf(7, 1, 11, 8, 4, 10), 8, true))
//    Solution().solution(955)
//    Interview().problem1(intArrayOf(-3, -1, 2, 7, 17))
//    Interview().problem2("aaaXXXXXAAYYYGBBBBBBAX")
}

/*for (i in 0..totalNumbers-1) {
    println("${arr[i]} $lastElement")
    if (arr[i] != (lastElement + 1)) {
        result[resultPosition++] = ++lastElement
    }
}*/
class Interview {
    fun problem1(arr: IntArray): IntArray {
        val totalNumbers = (arr.last() - arr[0]) + 1
        val missingNumbers = totalNumbers - arr.size
        var lastElement = arr[0]
        var resultPosition = 0
        var arrayPointer = 1
        val result = IntArray(missingNumbers)
        for (position in 0 until totalNumbers - 1) {
            if (arr[arrayPointer] != (lastElement + 1)) {
                result[resultPosition++] = ++lastElement
            } else {
                lastElement = arr[arrayPointer]
                arrayPointer++
            }
        }
        println(result.toList())
        return result
    }

    fun problem2(input: String): String {
        var result = ""
        var totalCount = 1
        for (index in 1 until input.length) { //3
            totalCount = if (isPreviousElementSameAsCurrent(input, index)) totalCount + 1 else 1
            if (totalCount == 3) {
                totalCount = 0
                result += input[index]
            }
        }
        return result
    }

    private fun isPreviousElementSameAsCurrent(input: String, index: Int) = input[index] == input[index - 1]
}


/*
class Codility {
    fun solution(A: IntArray, M: Int, temp: Boolean = false): Int {
        val result = hashSetOf<Int>()
        for (outerIndex in (1 until A.size - 1)) {
            for (innerIndex in (outerIndex + 1 until A.size)) {
                if (Math.abs(A[outerIndex] - A[innerIndex]) % M == 0) {
                    result.add(outerIndex)
                    result.add(innerIndex)
                }
            }
        }
        return Math.max(result.size, 1)
    }

    fun solution(X: Int, Y: Int, D: Int): Int {
        val difference = Y - X
        return (difference / D) + (if (difference % D > 0) 1 else 0)
    }

    fun solution(A: IntArray): Int {
        var result = A[0]
        var orList = A[0]
        var andList = A[0]
        for (index in (1 until A.size)) {
            println("AND of $result and ${A[index]} is ${result and A[index]}")
            result = result xor A[index]
//            println("OR of ${orList} and ${A[index] } is ${orList or A[index]}")
            orList = orList or A[index]
            andList = andList and A[index]
        }
        return result
    }

    fun solution(A: IntArray, K: Int): IntArray {
        val k = K % A.size
        if (k == 0) return A
        val result = IntArray(A.size)
        var i = 0
        for (index in (k - 1 until A.size)) {
            result[i++] = A[index]
        }
        for (index in (0 until k - 1)) {
            result[i++] = A[index]
        }
        return result
    }

    fun solution(N: Int): Int {
        val binaryArray = getBinaryRepresentation(N)
        val oneStack = Stack<Int>()
        val zeroStack = Stack<Int>()
        val binaryGaps = mutableListOf<Int>()
        for (binaryValue in binaryArray) {
            if (oneStack.empty() && binaryValue == 0) {
                continue
            }
            if (binaryValue == 0) {
                zeroStack.push(binaryValue)
            }
            if (binaryValue == 1) {
                if (oneStack.size > 0) {
                    oneStack.pop()
                    binaryGaps.add(zeroStack.size)
                    zeroStack.clear()
                }
                oneStack.push((binaryValue))
            }
        }
        return binaryGaps.maxOrNull() ?: 0
    }

    private fun getBinaryRepresentation(number: Int): List<Int> {
        val result = mutableListOf<Int>()
        var x = number
        while (x > 0) {
            result.add(x % 2)
            x /= 2
        }
        result.reverse()
        return result
    }
}*/
