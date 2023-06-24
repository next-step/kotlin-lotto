import io.kotest.core.spec.style.StringSpec

class ShuffledTest: StringSpec({
   "shuffled" {
       val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

       val shuffled = numbers.shuffled()

       println(shuffled)
       println(shuffled.subList(0, 6))
       println(numbers)
   }
})
