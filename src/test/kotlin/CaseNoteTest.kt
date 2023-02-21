import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import kotlin.test.assertFailsWith

class CaseNoteTest {
    @Before
    fun clearBeforeTest() {
        NotesService.clear()
    }

    @Test
    fun deleteNotes() {
        val comment1 = NoteComment(0, 0, 1, null, "message1")
        val note = Note(
            id = 0,
            title = "title1",
            text = "text1",
            date = 1,
            privacy = 0,
            comments = comment1
        )
        val noteCase = CaseNote(note, NotesService.notesList)

        noteCase.add(note)
        noteCase.delete(0)
        val result = NotesService.notesList[0].isDeleted

        assertEquals(true, result)
    }

    @Test
    fun deleteNoteComment() {

        val comment1 = NoteComment(0, 0, 1, null, "message1")
        val note = Note(
            id = 0,
            title = "title1",
            text = "text1",
            date = 1,
            privacy = 0,
            comments = comment1
        )
        val noteCase = CaseNote(note, NotesService.notesList)

        noteCase.add(note)
        noteCase.delete(0)
        val result = NotesService.notesList[0].comments?.isDeleted

        assertEquals(true, result)
    }

    @Test
    fun deleteComment() {

        val comment1 = NoteComment(0, 0, 1, null, "message1")
        val note = Note(
            id = 0,
            title = "title1",
            text = "text1",
            date = 1,
            privacy = 0,
            comments = comment1
        )
        val noteCase = CaseNote(note, NotesService.notesList)
        val commentCase = CaseNoteComment(comment1, NotesService.commentsList)

        noteCase.add(note)
        commentCase.add(comment1)
        commentCase.delete(0)
        val result1 = NotesService.commentsList[0].isDeleted
        val result2 = NotesService.notesList[0].comments?.isDeleted

        assertEquals(true, result1)
        assertEquals(true, result2)
    }

    @Test
    fun editNote() {
        val comment1 = NoteComment(0, 0, 1, null, "message1")

        val note = Note(
            id = 0,
            title = "title1",
            text = "text1",
            date = 1,
            privacy = 0,
            comments = comment1,
            isDeleted = true
        )
        val noteCase = CaseNote(note, NotesService.notesList)

        noteCase.add(note)
        val exception = assertFailsWith<RuntimeException> {
            noteCase.edit(0, note)
        }

        assertEquals("Не получится отредактировать, объект удален", exception.message)
    }

    @Test
    fun editComment() {
        val comment1 = NoteComment(0, 0, 1, null, "message1")
        val note = Note(
            id = 0,
            title = "title1",
            text = "text1",
            date = 1,
            privacy = 0,
            comments = comment1
        )
        val noteCase = CaseNote(note, NotesService.notesList)
        val commentCase = CaseNoteComment(comment1, NotesService.commentsList)

        noteCase.add(note)
        commentCase.add(comment1)

        val result = NotesService.commentsList[0].message

        assertEquals("message1", result)
    }
}