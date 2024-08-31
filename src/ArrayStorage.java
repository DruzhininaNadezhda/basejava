import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage=new Resume[10000];
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }
    Resume get(String uuid) {
        for(Resume resume: storage){
            if (resume!=null&&resume.uuid.equals(uuid)){
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i]==null&storage[i+1]!=null) {
                storage[i]=storage[i+1];
                storage[i+1]=null;
            } else if (storage[i]==null&storage[i+1]==null){
                break;
            }
            else if (storage[i].uuid.equals(uuid)) {
                if (storage[i+1]==null){
                    storage[i]=null;}
                else{
                    storage[i]=storage[i+1];
                    storage[i+1]=null;}
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        List<Resume> resumes=new ArrayList<>();
        for(Resume resume: storage) {
            if (resume != null) {
                resumes.add(resume);
            }
        }
        return  resumes.toArray(Resume[]::new);
    }

    int size() {
        return storage.length;
    }
}

