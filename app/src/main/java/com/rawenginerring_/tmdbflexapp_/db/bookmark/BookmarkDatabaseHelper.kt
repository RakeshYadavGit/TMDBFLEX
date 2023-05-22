package com.rawenginerring_.tmdbflexapp_.db.bookmark

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BookmarkDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 2
        private const val DATABASE_NAME = "bookmark.db"

        private const val TABLE_NAME = "bookmarks"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_MOVIE_ID = "movie_id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_POSTER_URL = "poster_url"
        private const val COLUMN_YEAR = "year"
        private const val COLUMN_RATING = "rating"
        private const val COLUMN_IS_TV_SHOW = "is_tv_show"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_BOOKMARKS_TABLE = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_MOVIE_ID TEXT, " +
                "$COLUMN_TITLE TEXT, " +
                "$COLUMN_POSTER_URL TEXT, " +
                "$COLUMN_YEAR TEXT, " +
                "$COLUMN_RATING TEXT, " +
                "$COLUMN_IS_TV_SHOW TEXT)"
        db?.execSQL(CREATE_BOOKMARKS_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addBookmark(bookmark: Bookmark): Long {
        val values = ContentValues()
        values.put(COLUMN_MOVIE_ID, bookmark.movieId)
        values.put(COLUMN_TITLE, bookmark.title)
        values.put(COLUMN_POSTER_URL, bookmark.posterUrl)
        values.put(COLUMN_YEAR, bookmark.year)
        values.put(COLUMN_RATING, bookmark.rating)
        values.put(COLUMN_IS_TV_SHOW, bookmark.isTvShow)

        return writableDatabase.use { db ->
            db.insert(TABLE_NAME, null, values)
        }
    }

    fun getAllBookmarks(isTVShow: Boolean): List<Bookmark> {
        val bookmarksList = mutableListOf<Bookmark>()
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_IS_TV_SHOW = ?"

        readableDatabase.use { db ->
            db.rawQuery(selectQuery, arrayOf(if (isTVShow) "TV" else "null")).use { cursor ->
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                    val movieId = cursor.getString(cursor.getColumnIndex(COLUMN_MOVIE_ID))
                    val title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
                    val posterUrl = cursor.getString(cursor.getColumnIndex(COLUMN_POSTER_URL))
                    val year = cursor.getString(cursor.getColumnIndex(COLUMN_YEAR))
                    val rating = cursor.getString(cursor.getColumnIndex(COLUMN_RATING))
                    val isTvShow = cursor.getString(cursor.getColumnIndex(COLUMN_IS_TV_SHOW))

                    bookmarksList.add(Bookmark(movieId, title, posterUrl, year, rating, isTvShow))
                }
            }
        }

        return bookmarksList
    }


    fun hasBookmark(movieId: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_MOVIE_ID = ?"
        val cursor = db.rawQuery(query, arrayOf(movieId))
        val hasBookmark = cursor.moveToFirst()

        cursor.close()
        db.close()
        return hasBookmark
    }

    fun deleteBookmark(movieId: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "$COLUMN_MOVIE_ID = ?", arrayOf(movieId))
    }
}
