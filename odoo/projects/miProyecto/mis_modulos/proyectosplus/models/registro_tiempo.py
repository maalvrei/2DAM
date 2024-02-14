from odoo import fields, models

class RegistroTiempo(models.Model):
    _name= 'proyectosplus.registro_tiempo'
    _description = 'Registro de tiempo'
    user_id = fields.Many2one(comodel_name='res.users', string='Usuario')
    date = fields.Date(string='Fecha')
    hours = fields.Float(string='Horas')
    description = fields.Text(string='Descripción')