package tnl.fibonacci

import java.math.BigDecimal

fun main(args: Array<String>) {
        var prev2 = BigDecimal.ZERO
        var prev1 = BigDecimal.ONE
        println(prev2)
        println(prev1)
        while (true) {
            val next = prev2 + prev1
            prev2 = prev1
            prev1 = next
            println(next)
        }
}
