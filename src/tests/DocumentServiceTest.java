package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import services.DocumentService;

public class DocumentServiceTest {

    private DocumentService documentService;

    @BeforeEach
    public void setUp() {
        documentService = new DocumentService();
    }

    @Test
    public void testAddDocument_ValidData() {
        String result = documentService.addDocument("Lập trình Java", "Nguyễn Văn A", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "300", 10);
        assertTrue(result.contains("Thêm tài liệu"));
        assertEquals(1, documentService.getDocuments().size());
    }

    @Test
    public void testAddDocument_EmptyTitle() {
        String result = documentService.addDocument("", "Nguyễn Văn B", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "200", 5);
        assertEquals("Lỗi: Tiêu đề không được để trống.", result);
        assertEquals(0, documentService.getDocuments().size());
    }

    @Test
    public void testAddDocument_NegativePages() {
        String result = documentService.addDocument("Lập trình Python", "Nguyễn Văn C", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "-50", 5);
        assertEquals("Lỗi: Số trang phải là một số nguyên hợp lệ.", result);
        assertEquals(0, documentService.getDocuments().size());
    }

    @Test
    public void testRemoveDocument_ExistingId() {
        documentService.addDocument("Lập trình Java", "Nguyễn Văn A", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "300", 10);
        String id = documentService.getDocuments().get(0).getId();
        boolean removed = documentService.removeDocument(id);
        assertTrue(removed);
        assertEquals(0, documentService.getDocuments().size());
    }

    @Test
    public void testRemoveDocument_NonExistingId() {
        boolean removed = documentService.removeDocument("non-existing-id");
        assertFalse(removed);
    }

    @Test
    public void testUpdateDocumentQuantity_Valid() {
        documentService.addDocument("Lập trình Java", "Nguyễn Văn A", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "300", 10);
        String id = documentService.getDocuments().get(0).getId();
        boolean updated = documentService.updateDocumentQuantity(id, 20);
        assertTrue(updated);
        assertEquals(20, documentService.getDocuments().get(0).getQuantity());
    }

    @Test
    public void testUpdateDocumentQuantity_NegativeQuantity() {
        documentService.addDocument("Lập trình Java", "Nguyễn Văn A", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "300", 10);
        String id = documentService.getDocuments().get(0).getId();
        boolean updated = documentService.updateDocumentQuantity(id, -5);
        assertFalse(updated);
        assertEquals(10, documentService.getDocuments().get(0).getQuantity());
    }

    @Test
    public void testUpdateDocumentQuantity_NonExistingId() {
        boolean updated = documentService.updateDocumentQuantity("non-existing-id", 20);
        assertFalse(updated);
    }
}
