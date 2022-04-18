package lotto.util

fun <K, V> Map<out K?, V?>.filterNotNull(): Map<K, V> =
    filter { it.key != null && it.value != null } as Map<K, V>
