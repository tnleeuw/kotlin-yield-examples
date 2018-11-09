package tnl.fibonacci

import java.math.BigDecimal

fun fibonacci(): Sequence<BigDecimal> {
    return sequence {
        var prev2 = BigDecimal.ZERO
        var prev1 = BigDecimal.ONE

        yield(prev2)
        yield(prev1)

        while (true) {
            val next = prev2 + prev1
            prev2 = prev1
            prev1 = next
            yield(next)
        }
    }
}

fun main(args: Array<String>) {
    for (n in fibonacci().take(10)) {
        println(n)
    }
}
