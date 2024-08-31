/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i <= size; i++) {
            storage[i] = null;
            size = 0;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
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
            if (size != 0 && storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size];
                size--;
                break;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] getAllResume = new Resume[size()];
        for (int i = 0; i < getAllResume.length; i++) {
            getAllResume[i] = storage[i];
        }
        return getAllResume;
    }

    int size() {
        return size;
    }
}

