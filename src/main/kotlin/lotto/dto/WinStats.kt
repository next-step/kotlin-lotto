package lotto.dto

import lotto.domain.WinResult

class WinStats(val matchMap: Map<WinResult, Int>, val yield: Number)
