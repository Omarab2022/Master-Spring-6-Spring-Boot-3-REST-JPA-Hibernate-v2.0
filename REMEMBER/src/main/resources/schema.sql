-- Initialize the contact_msg table
CREATE TABLE IF NOT EXISTS contact_msg (
                                           contact_id INT AUTO_INCREMENT PRIMARY KEY,
                                           name VARCHAR(100) NOT NULL,
    mobile_num VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    subject VARCHAR(100) NOT NULL,
    message VARCHAR(500) NOT NULL,
    status VARCHAR(10) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP DEFAULT NULL,
    updated_by VARCHAR(50) DEFAULT NULL
    );

-- Insert some sample data (optional)
INSERT INTO contact_msg (name, mobile_num, email, subject, message, status, created_at, created_by) VALUES
                                                                                                        ('John Doe', '1234567890', 'john@example.com', 'Test Subject', 'Test message', 'OPEN', CURRENT_TIMESTAMP, 'system'),
                                                                                                        ('Jane Smith', '0987654321', 'jane@example.com', 'Another Subject', 'Another test message', 'OPEN', CURRENT_TIMESTAMP, 'system');