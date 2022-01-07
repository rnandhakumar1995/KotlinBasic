fun main(): Int {
    val number = -1
    return (0 until number).filter {
        return@filter it % 3 == 0 || it % 5 == 0
    }.sum()
}

fun t(s: String): Boolean {
    val regex = Regex("[^A-Za-z0-9 ]")
    val givenFormattedString = regex.replace(s.lowercase(), "").replace("\\s".toRegex(), "")
    return givenFormattedString == givenFormattedString.reversed()
}

class LeetCode {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = 0
        val result = IntArray(m + n)
        var firstArrayPtr = 0
        var secondArrayPtr = 0
        while (i < m + n) {
            if (firstArrayPtr < m && nums1[firstArrayPtr] < nums2[secondArrayPtr]) {
                result[i] = nums1[firstArrayPtr]
                firstArrayPtr++
            } else {
                result[i] = nums2[secondArrayPtr]
                secondArrayPtr++
            }
            i++
            println(result.toMutableList())
        }
    }
}
