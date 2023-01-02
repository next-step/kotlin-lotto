import org.junit.jupiter.api.Test
import service.AutoNumberGenerator
import service.RandomNumberGenerator

class AutoNumberGeneratorTest {

    var autoNumberGenerator: AutoNumberGenerator
    var randomNumberGenerator = RandomNumberGenerator(1,45)
    init {
        autoNumberGenerator = AutoNumberGenerator(randomNumberGenerator)
    }
    @Test
    fun `자동번호생성테스트`() {
        val result = autoNumberGenerator.saveAfterGenerate(3)
        for (i: Int in 0 until result.size) {
            println(result.get(i).numbers)
        }
    }
}