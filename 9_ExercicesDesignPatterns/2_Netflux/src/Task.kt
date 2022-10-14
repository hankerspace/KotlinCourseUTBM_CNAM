enum class MediaCategory {
    ACTION,
    COMEDY,
    DRAMA,
    HORROR,
    THRILLER
}

abstract class Media(val name: String, val duration: Double, val category: MediaCategory, val isOpen: Boolean = true) {
    abstract fun play(startingTime: Double = 0.0)
}

class Movie(name: String, duration: Double, category: MediaCategory, val year: Int, isOpen: Boolean = true) : Media(name, duration, category, isOpen) {
    override fun play(startingTime: Double) {
        if(isOpen) {
            if(startingTime == 0.0) {
                println("Playing $name ($year) for $duration minutes")
            } else {
                println("Playing $name ($year) from $startingTime for $duration minutes")
            }
        } else {
            println("Sorry, $name is not available")
        }
    }

    override fun toString(): String {
        return "Movie(name='$name', duration=$duration, category=$category, year=$year, isOpen=$isOpen)"
    }
}

class Episode(name: String, duration: Double, category: MediaCategory, val number: Int, isOpen: Boolean = true) : Media(name, duration, category, isOpen) {
    override fun play(startingTime: Double) {
        if(isOpen) {
            if(startingTime == 0.0) {
                println("Playing $name (episode $number) for $duration minutes")
            } else {
                println("Playing $name (episode $number) from $startingTime for $duration minutes")
            }
        } else {
            println("Sorry, $name is not available")
        }
    }

    override fun toString(): String {
        return "Episode(name='$name', duration=$duration, category=$category, number=$number, isOpen=$isOpen)"
    }
}

class Season(val episodes: List<Episode>, val number: Int, val year: Int) {
    fun playWholeSeason() {
        println("Playing season $number")
        episodes.forEach { it.play() }
    }
}

class Series(val name: String, val seasons: List<Season>){
    fun playWholeSeries() {
        println("Playing series $name")
        seasons.forEach { it.playWholeSeason() }
    }
}

data class WatchedMedia(val media: Media, val currentTime: Double)

data class User(val name: String) {
    var watchedMediaList: List<WatchedMedia> = listOf()

    fun watch(media: Media, watchedTime: Double) {
        if(watchedMediaList.any { it.media == media }) {
            println("Resuming $media")
            watchedMediaList = watchedMediaList.filter { it.media != media } + WatchedMedia(media, watchedTime)
        } else {
            println("Starting $media")
            watchedMediaList = watchedMediaList + WatchedMedia(media, watchedTime)
        }
    }
}

fun main() {
    val user = User("John")
    val movie = Movie("The Matrix", 136.0, MediaCategory.ACTION, 1999)
    val episode = Episode("The Mandalorian", 40.0, MediaCategory.ACTION, 1)
    val season = Season(listOf(episode), 1, 2019)
    val series = Series("The Mandalorian", listOf(season))

    user.watch(movie, 0.0)
    user.watch(movie, 30.0)
    user.watch(episode, 0.0)
    user.watch(episode, 20.0)

    series.playWholeSeries()

}