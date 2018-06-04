package tnl.fibonacci

import java.math.BigDecimal

enum class FiboState { EL_ONE, EL_TWO, REST }

class FibonacciSequence: Sequence<BigDecimal> {
    override fun iterator(): Iterator<BigDecimal> {
        return object : Iterator<BigDecimal> {
            var prev2 = BigDecimal.ZERO
            var prev1 = BigDecimal.ONE
            var state = FiboState.EL_ONE
            override fun hasNext() = true

            override fun next(): BigDecimal {
                when (state) {
                    FiboState.EL_ONE -> {
                        state = FiboState.EL_TWO
                        return BigDecimal.ZERO
                    }
                    FiboState.EL_TWO -> {
                        state = FiboState.REST
                        return BigDecimal.ONE
                    }
                    FiboState.REST -> {
                        val next = prev1 + prev2
                        prev2 = prev1
                        prev1 = next
                        return next
                    }
                }
            }

        }
    }

}

fun main(args: Array<String>) {
    for (n in FibonacciSequence().take(10)) {
        println(n)
    }
}
