package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the StudentIDName type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "StudentIDNames", type = Model.Type.USER, version = 1)
public final class StudentIDName implements Model {
  public static final QueryField ID = field("StudentIDName", "id");
  public static QueryField UMBC_ID = field("StudentIDName", "UMBCID");
  public static final QueryField STUDENT_NAME = field("StudentIDName", "studentName");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String UMBCID;
  private final @ModelField(targetType="String", isRequired = true) String studentName;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getUmbcid() {
      return UMBCID.toString();
  }
  
  public String getStudentName() {
      return studentName;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private StudentIDName(String id, String UMBCID, String studentName) {
    this.id = id;
    this.UMBCID = field(UMBCID).toString();
    this.studentName = studentName;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      StudentIDName studentIdName = (StudentIDName) obj;
      return ObjectsCompat.equals(getId(), studentIdName.getId()) &&
              ObjectsCompat.equals(getUmbcid(), studentIdName.getUmbcid()) &&
              ObjectsCompat.equals(getStudentName(), studentIdName.getStudentName()) &&
              ObjectsCompat.equals(getCreatedAt(), studentIdName.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), studentIdName.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUmbcid())
      .append(getStudentName())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("StudentIDName {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("UMBCID=" + String.valueOf(getUmbcid()) + ", ")
      .append("studentName=" + String.valueOf(getStudentName()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static UmbcidStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static StudentIDName justId(String id) {
    return new StudentIDName(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
            UMBCID.toString(),
      studentName);
  }
  public interface UmbcidStep {
    StudentNameStep umbcid(String umbcid);
  }
  

  public interface StudentNameStep {
    BuildStep studentName(String studentName);
  }
  

  public interface BuildStep {
    StudentIDName build();
    BuildStep id(String id);
  }
  

  public static class Builder implements UmbcidStep, StudentNameStep, BuildStep {
    private String id;
    private String UMBCID;
    private String studentName;
    public Builder() {
      
    }
    
    private Builder(String id, String UMBCID, String studentName) {
      this.id = id;
      this.UMBCID = UMBCID;
      this.studentName = studentName;
    }
    
    @Override
     public StudentIDName build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new StudentIDName(
          id,
          UMBCID,
          studentName);
    }
    
    @Override
     public StudentNameStep umbcid(String umbcid) {
        Objects.requireNonNull(umbcid);
        this.UMBCID = umbcid;
        return this;
    }
    
    @Override
     public BuildStep studentName(String studentName) {
        Objects.requireNonNull(studentName);
        this.studentName = studentName;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String umbcid, String studentName) {
      super(id, UMBCID.toString(), studentName);
      Objects.requireNonNull(UMBCID);
      Objects.requireNonNull(studentName);
    }
    
    @Override
     public CopyOfBuilder umbcid(String umbcid) {
      return (CopyOfBuilder) super.umbcid(umbcid);
    }
    
    @Override
     public CopyOfBuilder studentName(String studentName) {
      return (CopyOfBuilder) super.studentName(studentName);
    }
  }
  

  public static class StudentIDNameIdentifier extends ModelIdentifier<StudentIDName> {
    private static final long serialVersionUID = 1L;
    public StudentIDNameIdentifier(String id) {
      super(id);
    }
  }
  
}
