package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the StudentExamRecord type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "StudentExamRecords", type = Model.Type.USER, version = 1)
public final class StudentExamRecord implements Model {
  public static final QueryField ID = field("StudentExamRecord", "id");
  public static String UMBCID = field("StudentExamRecord", "UMBCID").toString();
  public static final QueryField STUDENT_NAME = field("StudentExamRecord", "studentName");
  public static final QueryField BARCODE = field("StudentExamRecord", "barcode");
  public static final QueryField GRADE = field("StudentExamRecord", "grade");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String studentName;
  private final @ModelField(targetType="String", isRequired = true) String barcode;
  private final @ModelField(targetType="String") String grade;
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
      return UMBCID;
  }
  
  public String getStudentName() {
      return studentName;
  }
  
  public String getBarcode() {
      return barcode;
  }
  
  public String getGrade() {
      return grade;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private StudentExamRecord(String id, String UMBCID, String studentName, String barcode, String grade) {
    this.id = id;
    this.UMBCID = UMBCID;
    this.studentName = studentName;
    this.barcode = barcode;
    this.grade = grade;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      StudentExamRecord studentExamRecord = (StudentExamRecord) obj;
      return ObjectsCompat.equals(getId(), studentExamRecord.getId()) &&
              ObjectsCompat.equals(getUmbcid(), studentExamRecord.getUmbcid()) &&
              ObjectsCompat.equals(getStudentName(), studentExamRecord.getStudentName()) &&
              ObjectsCompat.equals(getBarcode(), studentExamRecord.getBarcode()) &&
              ObjectsCompat.equals(getGrade(), studentExamRecord.getGrade()) &&
              ObjectsCompat.equals(getCreatedAt(), studentExamRecord.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), studentExamRecord.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUmbcid())
      .append(getStudentName())
      .append(getBarcode())
      .append(getGrade())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("StudentExamRecord {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("UMBCID=" + String.valueOf(getUmbcid()) + ", ")
      .append("studentName=" + String.valueOf(getStudentName()) + ", ")
      .append("barcode=" + String.valueOf(getBarcode()) + ", ")
      .append("grade=" + String.valueOf(getGrade()) + ", ")
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
  public static StudentExamRecord justId(String id) {
    return new StudentExamRecord(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      UMBCID,
      studentName,
      barcode,
      grade);
  }
  public interface UmbcidStep {
    StudentNameStep umbcid(String umbcid);
  }
  

  public interface StudentNameStep {
    BarcodeStep studentName(String studentName);
  }
  

  public interface BarcodeStep {
    BuildStep barcode(String barcode);
  }
  

  public interface BuildStep {
    StudentExamRecord build();
    BuildStep id(String id);
    BuildStep grade(String grade);
  }
  

  public static class Builder implements UmbcidStep, StudentNameStep, BarcodeStep, BuildStep {
    private String id;
    private String UMBCID;
    private String studentName;
    private String barcode;
    private String grade;
    public Builder() {
      
    }
    
    private Builder(String id, String UMBCID, String studentName, String barcode, String grade) {
      this.id = id;
      this.UMBCID = UMBCID;
      this.studentName = studentName;
      this.barcode = barcode;
      this.grade = grade;
    }
    
    @Override
     public StudentExamRecord build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new StudentExamRecord(
          id,
          UMBCID,
          studentName,
          barcode,
          grade);
    }
    
    @Override
     public StudentNameStep umbcid(String umbcid) {
        Objects.requireNonNull(umbcid);
        this.UMBCID = umbcid;
        return this;
    }
    
    @Override
     public BarcodeStep studentName(String studentName) {
        Objects.requireNonNull(studentName);
        this.studentName = studentName;
        return this;
    }
    
    @Override
     public BuildStep barcode(String barcode) {
        Objects.requireNonNull(barcode);
        this.barcode = barcode;
        return this;
    }
    
    @Override
     public BuildStep grade(String grade) {
        this.grade = grade;
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
    private CopyOfBuilder(String id, String umbcid, String studentName, String barcode, String grade) {
      super(id, UMBCID, studentName, barcode, grade);
      Objects.requireNonNull(UMBCID);
      Objects.requireNonNull(studentName);
      Objects.requireNonNull(barcode);
    }
    
    @Override
     public CopyOfBuilder umbcid(String umbcid) {
      return (CopyOfBuilder) super.umbcid(umbcid);
    }
    
    @Override
     public CopyOfBuilder studentName(String studentName) {
      return (CopyOfBuilder) super.studentName(studentName);
    }
    
    @Override
     public CopyOfBuilder barcode(String barcode) {
      return (CopyOfBuilder) super.barcode(barcode);
    }
    
    @Override
     public CopyOfBuilder grade(String grade) {
      return (CopyOfBuilder) super.grade(grade);
    }
  }
  

  public static class StudentExamRecordIdentifier extends ModelIdentifier<StudentExamRecord> {
    private static final long serialVersionUID = 1L;
    public StudentExamRecordIdentifier(String id) {
      super(id);
    }
  }
  
}
