package lotto.study

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvSource

/**
 *
 * @author Leo
 */
class CsvTest {

    @ParameterizedTest
    @CsvSource("1;2;3, str", "3;4;5, str")
    fun csvTest(nums: String, str:String){
        val numbers = nums.split(";").map { it.toInt() }
        println(numbers)
    }

}
