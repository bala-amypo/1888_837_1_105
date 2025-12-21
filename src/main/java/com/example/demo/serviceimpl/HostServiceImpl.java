@Service
public class HostServiceImpl {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public Host createHost(Host h) {
        return hostRepository.save(h);
    }

    public Host getHost(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
    }
}
