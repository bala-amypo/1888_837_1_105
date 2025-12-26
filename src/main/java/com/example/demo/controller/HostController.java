@RestController
@RequestMapping("/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public Host createHost(@RequestBody Host host) {
        return hostService.saveHost(host);
    }

    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }

    @GetMapping("/{id}")
    public Host getHost(@PathVariable Long id) {
        return hostService.getHostById(id);
    }
}
