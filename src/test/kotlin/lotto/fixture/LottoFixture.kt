package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.LottoNumber

fun fakeBonusNumber(): LottoNumber {
    return LottoNumber(10)
}

fun fakeWinningLotto(): Lotto {
    return Lotto(1, 2, 3, 4, 5, 6)
}

fun fakeFirstRankLotto(): Lotto {
    return Lotto(1, 2, 3, 4, 5, 6)
}

fun fakeSecondRankLotto(): Lotto {
    return Lotto(1, 2, 3, 4, 5, 10)
}

fun fakeThirdRankLotto(): Lotto {
    return Lotto(1, 2, 3, 4, 5, 7)
}

fun fakeFourRankLotto(): Lotto {
    return Lotto(1, 2, 3, 4, 44, 45)
}

fun fakeFifthRankLotto(): Lotto {
    return Lotto(1, 2, 3, 43, 44, 45)
}

fun noRankLotto(): Lotto {
    return Lotto(45, 44, 43, 42, 41, 40)
}
