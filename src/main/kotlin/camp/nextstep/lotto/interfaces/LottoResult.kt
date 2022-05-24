package camp.nextstep.lotto.interfaces

import camp.nextstep.lotto.raffle.Winnings

class LottoResult(val winningsCountMap: Map<Winnings, Int>, val seed: Int, val totalEarn: Int)
