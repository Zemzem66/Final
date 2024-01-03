package org.openapitools.model.DTO;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

import org.openapitools.model.GetDocuments200ResponseResultsInnerNotesInner;

import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * GetDocument200Response
 */

@JsonTypeName("GetDocument_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-27T11:59:16.991824Z[Etc/UTC]")
public class DocumentDTO {

  private Integer id;

  private Integer correspondent;

  private Integer document;

  private Integer storagePath;

  private String title;

  private String note;

  @Valid
  private List<Integer> tags = new ArrayList<>();

  private String created;

  private String createdDate;

  private String modified;

  private String added;

  private Integer archiveSerialNumber;

  private String originalFileName;

  private String archivedFileName;

  private Integer user;

  private GetDocument200ResponsePermissions permissions;



  @Valid
  private List<@Valid GetDocuments200ResponseResultsInnerNotesInner> notes = new ArrayList<>();

  public DocumentDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DocumentDTO(Integer id, Integer correspondent, Integer document, Integer storagePath, String title, String note, List<Integer> tags, String created, String createdDate, String modified, String added, Integer archiveSerialNumber, String originalFileName, String archivedFileName, Integer user, GetDocument200ResponsePermissions permissions, List<@Valid GetDocuments200ResponseResultsInnerNotesInner> notes) {
    this.id = id;
    this.correspondent = correspondent;
    this.document = document;
    this.storagePath = storagePath;
    this.title = title;
    this.note = note;
    this.tags = tags;
    this.created = created;
    this.createdDate = createdDate;
    this.modified = modified;
    this.added = added;
    this.archiveSerialNumber = archiveSerialNumber;
    this.originalFileName = originalFileName;
    this.archivedFileName = archivedFileName;
    this.user = user;
    this.permissions = permissions;
    this.notes = notes;
  }

  public DocumentDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DocumentDTO correspondent(Integer correspondent) {
    this.correspondent = correspondent;
    return this;
  }

  /**
   * Get correspondent
   * @return correspondent
  */
  @NotNull 
  @Schema(name = "correspondent", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("correspondent")
  public Integer getCorrespondent() {
    return correspondent;
  }

  public void setCorrespondent(Integer correspondent) {
    this.correspondent = correspondent;
  }

  public DocumentDTO documentType(Integer documentType) {
    this.document = documentType;
    return this;
  }

  /**
   * Get documentType
   * @return documentType
  */
  @NotNull 
  @Schema(name = "document_type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("document_type")
  public Integer getDocument() {
    return document;
  }

  public void setDocument(Integer document) {
    this.document = document;
  }

  public DocumentDTO storagePath(Integer storagePath) {
    this.storagePath = storagePath;
    return this;
  }

  /**
   * Get storagePath
   * @return storagePath
  */
  @NotNull 
  @Schema(name = "storage_path", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("storage_path")
  public Integer getStoragePath() {
    return storagePath;
  }

  public void setStoragePath(Integer storagePath) {
    this.storagePath = storagePath;
  }

  public DocumentDTO title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @NotNull 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public DocumentDTO content(String content) {
    this.note = content;
    return this;
  }

  /**
   * Get content
   * @return content
  */
  @NotNull 
  @Schema(name = "content", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("content")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public DocumentDTO tags(List<Integer> tags) {
    this.tags = tags;
    return this;
  }

  public DocumentDTO addTagsItem(Integer tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
  */
  @NotNull 
  @Schema(name = "tags", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tags")
  public List<Integer> getTags() {
    return tags;
  }

  public void setTags(List<Integer> tags) {
    this.tags = tags;
  }

  public DocumentDTO created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  */
  @NotNull 
  @Schema(name = "created", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("created")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public DocumentDTO createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
  */
  @NotNull 
  @Schema(name = "created_date", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("created_date")
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public DocumentDTO modified(String modified) {
    this.modified = modified;
    return this;
  }

  /**
   * Get modified
   * @return modified
  */
  @NotNull 
  @Schema(name = "modified", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("modified")
  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }

  public DocumentDTO added(String added) {
    this.added = added;
    return this;
  }

  /**
   * Get added
   * @return added
  */
  @NotNull 
  @Schema(name = "added", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("added")
  public String getAdded() {
    return added;
  }

  public void setAdded(String added) {
    this.added = added;
  }

  public DocumentDTO archiveSerialNumber(Integer archiveSerialNumber) {
    this.archiveSerialNumber = archiveSerialNumber;
    return this;
  }

  /**
   * Get archiveSerialNumber
   * @return archiveSerialNumber
  */
  @NotNull 
  @Schema(name = "archive_serial_number", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("archive_serial_number")
  public Integer getArchiveSerialNumber() {
    return archiveSerialNumber;
  }

  public void setArchiveSerialNumber(Integer archiveSerialNumber) {
    this.archiveSerialNumber = archiveSerialNumber;
  }

  public DocumentDTO originalFileName(String originalFileName) {
    this.originalFileName = originalFileName;
    return this;
  }

  /**
   * Get originalFileName
   * @return originalFileName
  */
  @NotNull 
  @Schema(name = "original_file_name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("original_file_name")
  public String getOriginalFileName() {
    return originalFileName;
  }

  public void setOriginalFileName(String originalFileName) {
    this.originalFileName = originalFileName;
  }

  public DocumentDTO archivedFileName(String archivedFileName) {
    this.archivedFileName = archivedFileName;
    return this;
  }

  /**
   * Get archivedFileName
   * @return archivedFileName
  */
  @NotNull 
  @Schema(name = "archived_file_name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("archived_file_name")
  public String getArchivedFileName() {
    return archivedFileName;
  }

  public void setArchivedFileName(String archivedFileName) {
    this.archivedFileName = archivedFileName;
  }

  public DocumentDTO owner(Integer owner) {
    this.user = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  */
  @NotNull 
  @Schema(name = "owner", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("owner")
  public Integer getUser() {
    return user;
  }

  public void setUser(Integer user) {
    this.user = user;
  }

  public DocumentDTO permissions(GetDocument200ResponsePermissions permissions) {
    this.permissions = permissions;
    return this;
  }

  /**
   * Get permissions
   * @return permissions
  */
  @NotNull @Valid 
  @Schema(name = "permissions", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("permissions")
  public GetDocument200ResponsePermissions getPermissions() {
    return permissions;
  }

  public void setPermissions(GetDocument200ResponsePermissions permissions) {
    this.permissions = permissions;
  }

  public DocumentDTO notes(List<@Valid GetDocuments200ResponseResultsInnerNotesInner> notes) {
    this.notes = notes;
    return this;
  }
  //TODO: ADDED HERE DELETE IF WRONG
  public DocumentDTO note(String note) {
    this.note = note;
    return this;
  }
  public DocumentDTO addNotesItem(GetDocuments200ResponseResultsInnerNotesInner notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Get notes
   * @return notes
  */
  @NotNull @Valid 
  @Schema(name = "notes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("notes")
  public List<@Valid GetDocuments200ResponseResultsInnerNotesInner> getNotes() {
    return notes;
  }

  public void setNotes(List<@Valid GetDocuments200ResponseResultsInnerNotesInner> notes) {
    this.notes = notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentDTO documentDTO = (DocumentDTO) o;
    return Objects.equals(this.id, documentDTO.id) &&
        Objects.equals(this.correspondent, documentDTO.correspondent) &&
        Objects.equals(this.document, documentDTO.document) &&
        Objects.equals(this.storagePath, documentDTO.storagePath) &&
        Objects.equals(this.title, documentDTO.title) &&
        Objects.equals(this.note, documentDTO.note) &&
        Objects.equals(this.tags, documentDTO.tags) &&
        Objects.equals(this.created, documentDTO.created) &&
        Objects.equals(this.createdDate, documentDTO.createdDate) &&
        Objects.equals(this.modified, documentDTO.modified) &&
        Objects.equals(this.added, documentDTO.added) &&
        Objects.equals(this.archiveSerialNumber, documentDTO.archiveSerialNumber) &&
        Objects.equals(this.originalFileName, documentDTO.originalFileName) &&
        Objects.equals(this.archivedFileName, documentDTO.archivedFileName) &&
        Objects.equals(this.user, documentDTO.user) &&
        Objects.equals(this.permissions, documentDTO.permissions) &&
        Objects.equals(this.notes, documentDTO.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, correspondent, document, storagePath, title, note, tags, created, createdDate, modified, added, archiveSerialNumber, originalFileName, archivedFileName, user, permissions, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetDocument200Response {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    correspondent: ").append(toIndentedString(correspondent)).append("\n");
    sb.append("    documentType: ").append(toIndentedString(document)).append("\n");
    sb.append("    storagePath: ").append(toIndentedString(storagePath)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(note)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    added: ").append(toIndentedString(added)).append("\n");
    sb.append("    archiveSerialNumber: ").append(toIndentedString(archiveSerialNumber)).append("\n");
    sb.append("    originalFileName: ").append(toIndentedString(originalFileName)).append("\n");
    sb.append("    archivedFileName: ").append(toIndentedString(archivedFileName)).append("\n");
    sb.append("    owner: ").append(toIndentedString(user)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

