-- Use the library_manage_system database
USE library_manage_system;

-- Create the books table
CREATE TABLE books (
    book_id INT(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(250) DEFAULT NULL,
    author VARCHAR(250) DEFAULT NULL,
    publisher VARCHAR(250) DEFAULT NULL,
    year_published VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (book_id)
);

-- Create the members table
CREATE TABLE members (
    member_id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(250) DEFAULT NULL,
    email VARCHAR(250) DEFAULT NULL,
    phone VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (member_id)
);

-- Create the loans table
CREATE TABLE loans (
    loan_id INT(11) NOT NULL AUTO_INCREMENT,
    book_id INT(11) DEFAULT NULL,
    member_id INT(11) DEFAULT NULL,
    loan_date DATE DEFAULT NULL,
    return_date DATE DEFAULT NULL,
    PRIMARY KEY (loan_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);
