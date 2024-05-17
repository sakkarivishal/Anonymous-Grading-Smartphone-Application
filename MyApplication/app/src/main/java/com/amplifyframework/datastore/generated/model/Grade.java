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

/** This is an auto generated class representing the Grade type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Grades", type = Model.Type.USER, version = 1)
public final class Grade implements Model {
  public static final QueryField ID = field("Grade", "id");
  public static QueryField UMBCID = field("Grade", "UMBCID");
  public static final QueryField BARCODE = field("Grade", "barcode");
  public static final QueryField GRADE = field("Grade", "grade");
  private final @ModelField(targetType="ID", isRequired = true) String id;

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
      return UMBCID.toString();
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
  
  private Grade(String id, String UMBCID, String barcode, String grade) {
    this.id = id;
    this.UMBCID = QueryField.field(UMBCID);
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
      Grade grade = (Grade) obj;
      return ObjectsCompat.equals(getId(), grade.getId()) &&
              ObjectsCompat.equals(getUmbcid(), grade.getUmbcid()) &&
              ObjectsCompat.equals(getBarcode(), grade.getBarcode()) &&
              ObjectsCompat.equals(getGrade(), grade.getGrade()) &&
              ObjectsCompat.equals(getCreatedAt(), grade.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), grade.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUmbcid())
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
      .append("Grade {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("UMBCID=" + String.valueOf(getUmbcid()) + ", ")
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
  public static Grade justId(String id) {
    return new Grade(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
            UMBCID.toString(),
      barcode,
      grade);
  }
  public interface UmbcidStep {
    BarcodeStep umbcid(String umbcid);
  }
  

  public interface BarcodeStep {
    BuildStep barcode(String barcode);
  }
  

  public interface BuildStep {
    Grade build();
    BuildStep id(String id);
    BuildStep grade(String grade);
  }
  

  public static class Builder implements UmbcidStep, BarcodeStep, BuildStep {
    private String id;
    private String UMBCID;
    private String barcode;
    private String grade;
    public Builder() {
      
    }
    
    private Builder(String id, String UMBCID, String barcode, String grade) {
      this.id = id;
      this.UMBCID = UMBCID;
      this.barcode = barcode;
      this.grade = grade;
    }
    
    @Override
     public Grade build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Grade(
          id,
          UMBCID,
          barcode,
          grade);
    }
    
    @Override
     public BarcodeStep umbcid(String umbcid) {
        Objects.requireNonNull(umbcid);
        this.UMBCID = umbcid;
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
    private CopyOfBuilder(String id, String umbcid, String barcode, String grade) {
      super(id, UMBCID.toString(), barcode, grade);
      Objects.requireNonNull(UMBCID);
      Objects.requireNonNull(barcode);
    }
    
    @Override
     public CopyOfBuilder umbcid(String umbcid) {
      return (CopyOfBuilder) super.umbcid(umbcid);
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
  

  public static class GradeIdentifier extends ModelIdentifier<Grade> {
    private static final long serialVersionUID = 1L;
    public GradeIdentifier(String id) {
      super(id);
    }
  }
  
}
