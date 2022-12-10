package lotto.domain.generator

class RandomGenerator: Generator {

    val nums : Array<Boolean> = Array(46) { false }

    override fun generate(): List<Int> {
        val list: MutableList<Int> = mutableListOf()

        while(list.size < 6) {
            val random = (1..45).random()
            if(!nums[random]) {
                nums[random] = true
                list.add(random)
            }
        }

        nums.fill(false)

        return list.toList()
    }
}