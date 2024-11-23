package lotto

class LottoNumber private constructor(val number: Int) {
    companion object {
        private val cache = (1..45).associateWith { LottoNumber(it) }

        fun of(number: Int): LottoNumber {
            return cache[number] ?: throw IllegalArgumentException("로또 번호는 1에서 45사이여야 합니다.")
        }
    }
}
