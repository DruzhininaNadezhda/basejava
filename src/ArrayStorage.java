/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i <= size(); i++) {
            storage[i]=null;
        }
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
        for (Resume resume : storage) {
            if (resume != null && resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if ((storage[i] == null & storage[i + 1] != null)
                    || (storage[i] != null&&storage[i].uuid.equals(uuid))) {
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
            } else if (storage[i] == null & storage[i + 1] == null) {
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] getAllResume=new Resume[size()];
        for (int i = 0; i < getAllResume.length; i++) {
                getAllResume[i]=storage[i];
            }
        return getAllResume;
    }

    int size() {
        int arraySize = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                ++arraySize;
            }
        }
        return arraySize;
    }
}

