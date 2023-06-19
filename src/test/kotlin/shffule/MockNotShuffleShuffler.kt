package shffule

class MockNotShuffleShuffler<T> : Shuffler<T> {

    override fun shuffled(source: List<T>): List<T> {
        return source
    }
}
