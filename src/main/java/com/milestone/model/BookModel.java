package com.milestone.model;

/**
 * Model class representing a book in the library system
 */
public class BookModel {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private boolean available;  // true = can checkout

    /**
     * Constructor for creating a new book
     * @param id the unique book identifier
     * @param title the book title
     * @param author the book author
     * @param genre the book genre
     * @param available whether the book is available for checkout
     */
    public BookModel(Long id, String title, String author, String genre, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }

    // Getters & Setters
    /** @return the book ID */
    public Long getId() { return id; }
    /** @return the book title */
    public String getTitle() { return title; }
    /** @return the book author */
    public String getAuthor() { return author; }
    /** @return the book genre */
    public String getGenre() { return genre; }
    /** @return true if book is available for checkout */
    public boolean isAvailable() { return available; }

    /** @param id the book ID to set */
    public void setId(Long id) { this.id = id; }
    /** @param title the book title to set */
    public void setTitle(String title) { this.title = title; }
    /** @param author the book author to set */
    public void setAuthor(String author) { this.author = author; }
    /** @param genre the book genre to set */
    public void setGenre(String genre) { this.genre = genre; }
    /** @param available the availability status to set */
    public void setAvailable(boolean available) { this.available = available; }
}
