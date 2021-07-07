import java.text.SimpleDateFormat
import java.util.*

fun Int.fiboncacci(): Int {
    return if (this == 0 || this == 1) return 1 else (this * (this - 1).fiboncacci())
}

class ScopeFunctions {
    fun applyUsage(): IntArray {
        return IntArray(5) { it }.apply {
            for (index in 0 until this.size) {
                set(index, index.fiboncacci())
            }
        }
    }

    fun letUsage(): List<Int> {
        IntArray(5) { it }.let { array ->
            return array.filter { it % 2 == 0 }
        }
    }

    fun alsoUsage(): IntArray {
        return IntArray(5) { it }.also {
            println("Print list ${it.toList()}")
        }

    }

    fun <T> withUsage(list: List<T>): Sequence<T> {
        return with(list) {
            asSequence()
        }
    }

    fun runUsage() {
        val formattedDate = Date().run {
            SimpleDateFormat("dd, MMM").format(this)
        }
        println(formattedDate)
    }
}