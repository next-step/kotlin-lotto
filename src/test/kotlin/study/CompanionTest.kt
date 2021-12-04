package study

import org.junit.jupiter.api.Test

class CompanionTest {
    @Test
    fun `companion 명시`() {
        val foo = Foo()
        val result = listOf(1, 2, 3)
            .map(foo::multiply)
            .joinToString()
        println(result)

        val result1 = listOf(1, 2, 3)
            .map(Foo::multiply)
            .joinToString()
        println(result1)
    }
}
