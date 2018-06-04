package tnl.fibonacci

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class FibonacciSequenceTest {
    @Test
    fun fibonacci1() {
        testFibonacci(listOf(BigDecimal.ZERO))
    }

    @Test
    fun fibonacci2() {
        testFibonacci(listOf(BigDecimal.ZERO, BigDecimal.ONE))
    }

    @Test
    fun fibonacci3() {
        testFibonacci(listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377).map { BigDecimal(it) })
    }

    @Test
    fun fibonacci4() {
        println(FibonacciSequence().take(400).toList())
    }

    private fun testFibonacci(expected: List<BigDecimal>) {
        val result = FibonacciSequence().take(expected.size).toList()
        Assertions.assertEquals(expected, result)
    }

}
