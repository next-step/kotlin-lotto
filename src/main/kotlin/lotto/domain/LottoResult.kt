package lotto.domain

sealed class LottoResult(val krw: KRW, private var _count: Int) {

    val count
        get() = _count

    fun calculatePrize(): Int {
        return krw.money * _count
    }

    fun increase() {
        _count++
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LottoResult) return false

        if (krw != other.krw) return false
        if (_count != other._count) return false

        return true
    }

    override fun hashCode(): Int {
        var result = krw.hashCode()
        result = 31 * result + _count
        return result
    }
}

class NotWin(count: Int = 0) : LottoResult(KRW(0), count)

class FourthWin(count: Int = 0) : LottoResult(KRW(5000), count)

class ThirdWin(count: Int = 0) : LottoResult(KRW(50000), count)

class SecondWin(count: Int = 0) : LottoResult(KRW(150000), count)

class FirstWin(count: Int = 0) : LottoResult(KRW(2000000000), count)
