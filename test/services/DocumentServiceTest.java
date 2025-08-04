package test.services;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import models.Book;
import models.Document;
import services.DocumentService;

public class DocumentServiceTest {
    
    private DocumentService documentService;
    
    @Before
    public void setUp() {
        documentService = new DocumentService();
    }
    
    @Test
    public void testAddDocument() {
        String result = documentService.addDocument("Java Programming", "John Doe", "2023-01-01", 
                                                   "Tech Books", "English", "300", 5);
        
        assertEquals("Should return success message", "Thêm tài liệu 'Java Programming' thành công!", result);
        assertEquals("Document count should be 1", 1, documentService.getDocuments().size());
    }
    
    @Test
    public void testAddDocument_InvalidInput() {
        String result = documentService.addDocument("", "John Doe", "2023-01-01", 
                                                   "Tech Books", "English", "300", 5);
        
        assertEquals("Should return error message for empty title", "Lỗi: Tiêu đề không được để trống.", result);
    }
    
    @Test
    public void testFindDocumentById() {
        documentService.addDocument("Java Programming", "John Doe", "2023-01-01", 
                                   "Tech Books", "English", "300", 5);
        
        Document found = null;
        for (Document doc : documentService.getDocuments()) {
            if (doc.getTitle().equals("Java Programming")) {
                found = doc;
                break;
            }
        }
        
        assertNotNull("Document should be found", found);
        assertEquals("Found document should have correct title", "Java Programming", found.getTitle());
    }
    
    @Test
    public void testBorrowDocument() {
        documentService.addDocument("Java Programming", "John Doe", "2023-01-01", 
                                   "Tech Books", "English", "300", 5);
        
        Document targetDoc = null;
        for (Document doc : documentService.getDocuments()) {
            if (doc.getTitle().equals("Java Programming")) {
                targetDoc = doc;
                break;
            }
        }
        
        String result = documentService.borrowDocument(targetDoc.getId());
        assertEquals("Should return success message", "Mượn tài liệu 'Java Programming' thành công!", result);
        assertEquals("Quantity should decrease by 1", 4, targetDoc.getQuantity());
    }
    
    @Test
    public void testRemoveDocument() {
        documentService.addDocument("Java Programming", "John Doe", "2023-01-01", 
                                   "Tech Books", "English", "300", 5);
        
        Document targetDoc = null;
        for (Document doc : documentService.getDocuments()) {
            if (doc.getTitle().equals("Java Programming")) {
                targetDoc = doc;
                break;
            }
        }
        
        boolean result = documentService.removeDocument(targetDoc.getId());
        assertTrue("Document should be removed successfully", result);
        assertEquals("Document count should be 0", 0, documentService.getDocuments().size());
    }
    
    @Test
    public void testUpdateDocumentQuantity() {
        documentService.addDocument("Java Programming", "John Doe", "2023-01-01", 
                                   "Tech Books", "English", "300", 5);
        
        Document targetDoc = null;
        for (Document doc : documentService.getDocuments()) {
            if (doc.getTitle().equals("Java Programming")) {
                targetDoc = doc;
                break;
            }
        }
        
        boolean result = documentService.updateDocumentQuantity(targetDoc.getId(), 10);
        assertTrue("Update should succeed", result);
        assertEquals("Quantity should be updated to 10", 10, targetDoc.getQuantity());
    }
}
