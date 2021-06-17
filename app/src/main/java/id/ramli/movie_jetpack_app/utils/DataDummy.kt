package id.ramli.movie_jetpack_app.utils

import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieResponse
import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieResponse
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowResponse
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowResponse

/**
 * Created by ramliy10 on 02/05/21.
 */

object DataDummy {

    fun generateDummyDetailMovie() : DetailMovieEntity{
        return DetailMovieEntity(
            1,
            337404,
            "Cruella",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            "hjS9mH8KvRiGHgjk6VUZH7OT0Ng.jpg",
            "2021-05-26",
            "8.8",
            false,
            "134")
    }

    fun generateDummyDetailMovieResponse() : DetailMovieResponse{
        return DetailMovieResponse(

            337404,
            "Cruella",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            "hjS9mH8KvRiGHgjk6VUZH7OT0Ng.jpg",
            "2021-05-26",
            "8.8",
            "134")
    }

    fun generateDummyDetailTvShow() : DetailTvShowEntity{
        return DetailTvShowEntity(
            1,
            63174,
            "Lucifer",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "2016-01-25",
            "Returning Series",
            "8.6",
        false)
    }

    fun generateDummyDetailTvShowResponse() : DetailTvShowResponse{
        return DetailTvShowResponse(
            63174,
            "Lucifer",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "2016-01-25",
            "Returning Series",
            "8.6")
    }

    fun generateDummyMovies(): List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                1,
                337404,
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "hjS9mH8KvRiGHgjk6VUZH7OT0Ng.jpg",
                "2021-05-26",
                "8.6",
            false)
            )
        movies.add(
            MovieEntity(
                2,
                632357,
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
                "2021-03-31",
                "7.1",
            false)
            )
        movies.add(
            MovieEntity(
                3,
                503736,
                "Army of the Dead",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                "z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                "2021-05-14",
                "6.6",
            false)
            )
        movies.add(
            MovieEntity(
                4,
                637649,
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                "YxopfHpsCV1oF8CZaL4M3Eodqa.jpg",
                "2021-04-22",
                "8",
            false)
            )
        movies.add(
            MovieEntity(
                5,
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "2021-04-07",
                "7.6",
            false)
            )
        movies.add(
            MovieEntity(
                6,
                823855,
                "I Am All Girls",
                "A special crimes investigator forms an unlikely bond with a serial killer to bring down a global child sex trafficking syndicate.",
                "m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg",
                "2021-05-14",
                "7",
            false)
            )
        movies.add(
            MovieEntity(
                7,
                567189,
                "Tom Clancy's Without Remorse",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "2021-04-29",
                "7.2",
            false)
            )
        movies.add(
            MovieEntity(
                8,
                399566,
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "8.1",
            false)
            )
        movies.add(
            MovieEntity(
                9,
                578701,
                "Those Who Wish Me Dead",
                "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                "xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                "2021-05-05",
                "7",
            false)
            )
        movies.add(
            MovieEntity(
                10,
                808023,
                "The Virtuoso",
                "A lonesome stranger with nerves of steel must track down and kill a rogue hitman to satisfy an outstanding debt. But the only information he's been given is a time and location where to find his quarry. No name. No description. Nothing.",
                "vXHzO26mJaOt4VO7ZFiM6No5ScT.jpg",
                "2021-04-30",
                "6.1",
            false)
            )

        return movies

    }

    fun generateDummyMoviesResponse(): List<MovieResponse>{
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                337404,
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "hjS9mH8KvRiGHgjk6VUZH7OT0Ng.jpg",
                "2021-05-26",
                "8.8")
        )
        movies.add(
            MovieResponse(
                632357,
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
                "2021-03-31",
                "7.1")
        )
        movies.add(
            MovieResponse(
                503736,
                "Army of the Dead",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                "z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                "2021-05-14",
                "6.6")
        )
        movies.add(
            MovieResponse(
                637649,
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                "YxopfHpsCV1oF8CZaL4M3Eodqa.jpg",
                "2021-04-22",
                "8")
        )
        movies.add(
            MovieResponse(
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "2021-04-07",
                "7.6")
        )
        movies.add(
            MovieResponse(
                823855,
                "I Am All Girls",
                "A special crimes investigator forms an unlikely bond with a serial killer to bring down a global child sex trafficking syndicate.",
                "m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg",
                "2021-05-14",
                "7")
        )
        movies.add(
            MovieResponse(
                567189,
                "Tom Clancy's Without Remorse",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "2021-04-29",
                "7.2")
        )
        movies.add(
            MovieResponse(
                399566,
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "8.1")
        )
        movies.add(
            MovieResponse(
                578701,
                "Those Who Wish Me Dead",
                "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                "xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                "2021-05-05",
                "7")
        )
        movies.add(
            MovieResponse(
                808023,
                "The Virtuoso",
                "A lonesome stranger with nerves of steel must track down and kill a rogue hitman to satisfy an outstanding debt. But the only information he's been given is a time and location where to find his quarry. No name. No description. Nothing.",
                "vXHzO26mJaOt4VO7ZFiM6No5ScT.jpg",
                "2021-04-30",
                "6.1")
        )

        return movies

    }

    fun generateDummyTvShows(): List<TvShowEntity>{
        val tvShows = ArrayList<TvShowEntity>()
        tvShows.add(
            TvShowEntity(
                1,
                84958,
                "Loki",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                "rX1wQMTKFqF0gvZyS0DDQqgnQPB.jpg",
                "2021-06-09",
                "8.1",
            false)
            )
        tvShows.add(
            TvShowEntity(
                2,
                91557,
                "Ragnarok",
                "A small Norwegian town experiencing warm winters and violent downpours seems to be headed for another Ragnarök -- unless someone intervenes in time.",
                "xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                "2020-01-31",
                "8",
            false)
            )
        tvShows.add(
            TvShowEntity(
                3,
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "2014-10-07",
                "7.7",
            false)
            )
        tvShows.add(
            TvShowEntity(
                4,
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                "8.6",
            false)
            )
        tvShows.add(
            TvShowEntity(
                5,
                120168,
                "Who Killed Sara?",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "2021-03-24",
                "7.8",
            false)
            )
        tvShows.add(
            TvShowEntity(
                6,
                1416,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital",
                "clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "2005-03-27",
                "8.2",
            false)
            )
        tvShows.add(
            TvShowEntity(
                7,
                95057,
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "2021-02-23",
                "8.3",
            false)
            )
        tvShows.add(
            TvShowEntity(
                8,
                88396,
                "The Falcon and the Winter Soldier",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                "6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "2021-03-19",
                "7.9",
            false)
            )
        tvShows.add(
            TvShowEntity(
                9,
                80240,
                "The Queen of Flow",
                "After spending seventeen years in prison unfairly, a talented songwriter seeks revenge on the men who sank her and killed her family.",
                "fuVuDYrs8sxvEolnYr0wCSvtyTi.jpg",
                "2018-06-12",
                "8",
            false)
            )
        tvShows.add(
            TvShowEntity(
                10,
                95557,
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "2021-03-26",
                "8.9",
                false
            )
        )

        return tvShows
    }

    fun generateDummyTvShowsResponse(): List<TvShowResponse>{
        val tvShows = ArrayList<TvShowResponse>()
        tvShows.add(
            TvShowResponse(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                "8.5")
        )
        tvShows.add(
            TvShowResponse(
                91557,
                "Ragnarok",
                "A small Norwegian town experiencing warm winters and violent downpours seems to be headed for another Ragnarök -- unless someone intervenes in time.",
                "xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                "2020-01-31",
                "8")
        )
        tvShows.add(
            TvShowResponse(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "2014-10-07",
                "7.7")
        )
        tvShows.add(
            TvShowResponse(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                "8.6")
        )
        tvShows.add(
            TvShowResponse(
                120168,
                "Who Killed Sara?",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "2021-03-24",
                "7.8")
        )
        tvShows.add(
            TvShowResponse(
                1416,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital",
                "clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "2005-03-27",
                "8.2")
        )
        tvShows.add(
            TvShowResponse(
                95057,
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "2021-02-23",
                "8.3")
        )
        tvShows.add(
            TvShowResponse(
                88396,
                "The Falcon and the Winter Soldier",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                "6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "2021-03-19",
                "7.9")
        )
        tvShows.add(
            TvShowResponse(
                80240,
                "The Queen of Flow",
                "After spending seventeen years in prison unfairly, a talented songwriter seeks revenge on the men who sank her and killed her family.",
                "fuVuDYrs8sxvEolnYr0wCSvtyTi.jpg",
                "2018-06-12",
                "8")
        )
        tvShows.add(
            TvShowResponse(
                95557,
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "2021-03-26",
                "8.9"
            )
        )

        return tvShows
    }
}