package id.ramli.movie_jetpack_app.data.source.movie

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by ramliy10 on 02/06/21.
 */
@Entity(tableName = "tb_detail_movie")
@Parcelize
data class DetailMovieEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "movieId")
    var movieId: Int? = 0,
    @ColumnInfo(name = "title")
    var title: String? = null,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "poster")
    var poster: String? = null,
    @ColumnInfo(name = "release")
    var release: String? = null,
    @ColumnInfo(name = "rating")
    var rating: String? = null,
    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,
    @ColumnInfo(name = "duration")
    val duration: String? = null
): Parcelable