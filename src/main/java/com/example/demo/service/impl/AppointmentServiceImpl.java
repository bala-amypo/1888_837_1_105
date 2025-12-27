@Override
public Appointment createAppointment(Long visitorId, Long hostId, Appointment appointment) {

    if (appointment.getAppointmentDate().isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("appointmentDate cannot be past");
    }

    Visitor visitor = visitorRepository.findById(visitorId)
            .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

    Host host = hostRepository.findById(hostId)
            .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

    appointment.setVisitor(visitor);
    appointment.setHost(host);
    appointment.setStatus("SCHEDULED");

    return appointmentRepository.save(appointment);
}
