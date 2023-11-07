package lotto

class Lotto(private vararg val numbers: Int) {
    fun match(lotto: Lotto): Int {
        var count = 0
        for (n in numbers) {
            for (o in lotto.numbers) {
                if (n == o) {
                    count++
                    continue
                }
            }
        }
        return count
    }
}
