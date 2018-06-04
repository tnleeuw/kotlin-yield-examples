package tnl.group

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GroupTest {

    lateinit var group: Group

    @BeforeEach
    fun setup() {
        group = Group(listOf("P1", "P2", "P3", "P4"), listOf(
                Group(listOf("A", "B", "C", "D")),
                Group(listOf("P4", "P5", "P7", "P9", "D", "E", "F"), listOf(
                        Group(listOf("P6", "P7", "P8", "P9"),
                                listOf(Group(listOf(), listOf(
                                        Group(listOf("D1", "D2", "D3", "D4")),
                                        Group(listOf("D8", "D7", "D6", "D5")),
                                        Group(listOf("X8", "X7", "Y6", "Y5")),
                                        Group(listOf("Z8", "Z7", "Z6", "Z5"), listOf(
                                                Group(listOf("B1", "B2")),
                                                Group(listOf("B4", "B6", "B9"))
                                        ))
                                ))))
                ))))
    }

    @Test
    fun testAllPermissions() {
        assertEquals(group.getAllPermissions1(), group.getAllPermissions2())
    }

    @Test
    fun repeatManyTimes1() {
        for (i in 1..100000) {
            group.getAllPermissions1()
        }
    }

    @Test
    fun repeatManyTimes2() {
        for (i in 1..100000) {
            group.getAllPermissions2()
        }
    }
}
