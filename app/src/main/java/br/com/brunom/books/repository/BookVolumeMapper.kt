package br.com.brunom.books.repository

import br.com.brunom.books.model.ImageLinks
import br.com.brunom.books.model.Volume
import br.com.brunom.books.model.VolumeInfo

object BookVolumeMapper{
    fun bookToVolume(book: Book): Volume {
        return Volume(
            book.id,
            book.selfLink,
            VolumeInfo(
                book.title,
                book.description,
                book.authors,
                book.publisher,
                book.publishedDate,
                book.pageCount,
                ImageLinks(
                    book.smallThumbnail,
                    book.thumbnail
                )
            )
        )

    }

    fun volumeToBook(volume: Volume): Book {
        return Book(
            volume.id,
            volume.selfLink,
            volume.volumeInfo.title,
            volume.volumeInfo.description,
            volume.volumeInfo.authors,
            volume.volumeInfo.publisher,
            volume.volumeInfo.publishedDate,
            volume.volumeInfo.pageCount,
            volume.volumeInfo.imageLinks?.smallThumbnail ?:"",
            volume.volumeInfo.imageLinks?.thumbnail ?: ""

        )
    }

}