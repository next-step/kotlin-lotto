package lotto.domain

enum class LottoEnum(val num: Int, val price: Int) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    companion object {
        fun of(num: Int): LottoEnum? {
            return when (num) {
                THREE.num -> {
                    THREE
                }

                FOUR.num -> {
                    FOUR
                }

                FIVE.num -> {
                    FIVE
                }

                SIX.num -> {
                    SIX
                }

                else -> {
                    null
                }
            }
        }
    }
}
