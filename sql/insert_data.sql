-- Insert initial data into the books table
INSERT INTO books (title, author, publisher, year_published) VALUES
('To Kill a Mockingbird', 'Harper Lee', 'J.B. Lippincott & Co.', '1960'),
('1984', 'George Orwell', 'Secker & Warburg', '1949'),
('The Great Gatsby', 'F. Scott Fitzgerald', 'Charles Scribner\'s Sons', '1925');

-- Insert initial data into the members table
INSERT INTO members (name, email, phone) VALUES
('John Doe', 'john.doe@example.com', '123-456-7890'),
('Jane Smith', 'jane.smith@example.com', '098-765-4321');

-- Insert initial data into the loans table
INSERT INTO loans (book_id, member_id, loan_date, return_date) VALUES
(1, 1, '2023-06-30', '2023-07-14'),
(2, 2, '2023-06-30', '2023-07-14');
