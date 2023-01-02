import org.junit.jupiter.api.Test
import service.RandomNumberGenerator

class RandomNumberGeneratorTest {

    @Test
    fun `랜덤하게`(){
        val randomNumberGenerator = RandomNumberGenerator(1,45)
        println(randomNumberGenerator.getGeneratedNumber())
    }
}