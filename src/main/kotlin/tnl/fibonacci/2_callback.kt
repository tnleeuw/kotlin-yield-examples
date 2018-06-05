package tnl.fibonacci

import java.math.BigDecimal

fun fibonacci(cb: (BigDecimal) -> Unit) {
    var prev2 = BigDecimal.ZERO
    var prev1 = BigDecimal.ONE
    cb(prev2)
    cb(prev1)
    while (true) {
        val next = prev2 + prev1
        prev2 = prev1
        prev1 = next
        cb(next)
    }
}

fun main(args: Array<String>) {
    fibonacci { println(it) }
}
